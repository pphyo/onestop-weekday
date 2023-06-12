import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { balanceType } from 'src/app/services/data';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AccountsService } from 'src/app/services/accounts.service';
import { CategoryService } from 'src/app/services/categories.service';

@Component({
  selector: 'app-balance-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './balance-form.component.html'
})
export class BalanceFormComponent {

  balType = balanceType
  form:FormGroup
  selectedType = 'Expense'

  @Input()
  creation:any

  accList:any = []
  incList:any = []
  expList:any = []

  @Output()
  onSave = new EventEmitter<any>

  constructor(
    private builder:FormBuilder,
    private accService:AccountsService,
    private catService:CategoryService){

    this.accService.search().subscribe(result => this.accList = result)
    this.catService.findByType('Income').subscribe(result => this.incList = result)
    this.catService.findByType('Expense').subscribe(result => this.expList = result)

    this.form = this.validateForm()
  }

  @Input()
  set editData(data:any) {
    this.initForm()

    if(data?.id)
      this.form.patchValue(data)

    this.creation = data?.creation
    this.selectedType = data?.type ? data?.type : 'Expense'
  }

  save() {
    let value = {...this.form.value, type: this.selectedType, creation: this.creation}
    this.onSave.emit(value)
    this.initForm()
  }

  selectType(type:any) {
    this.selectedType = type

    this.form = this.validateForm()
  }

  validateForm() {
    return this.builder.group({
      id: 0,
      accountFrom: ['', Validators.required],
      accountTo: this.selectedType == 'Transfer' ? ['', Validators.required] : '',
      category: this.selectedType == 'Transfer' ? '' : ['', Validators.required],
      amount: [0, Validators.min(1)],
      note: '',
      creation: ''
    })
  }

  initForm() {
    this.selectedType = 'Expense'
    this.form.patchValue({
      id: 0,
      accountFrom: '',
      accountTo: '',
      category: '',
      amount: 0,
      note: '',
      creation: ''
    })
  }

  transferCheck() {
    return this.form.get('accountFrom')?.value && this.form.get('accountTo')?.value && this.form.get('accountFrom')?.value == this.form.get('accountTo')?.value
  }

}
