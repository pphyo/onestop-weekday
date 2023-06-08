import { Component, EventEmitter, Output } from '@angular/core';
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
  selectedType:any = 'Expense'
  date = new Date

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

    this.form = builder.group({
      accountFrom: ['', Validators.required],
      accountTo: '',
      category: '',
      amount: [0, Validators.required],
      note: '',
      createAt: ''
    })
  }

  save() {
    let value = {...this.form.value, type: this.selectedType}
    this.onSave.emit(value)
    this.initForm()
  }

  selectType(type:any) {
    this.selectedType = type
  }

  initForm() {
    this.selectedType = undefined
    this.form.patchValue({
      accountFrom: '',
      accountTo: '',
      category: '',
      amount: 0,
      note: '',
      createAt: ''
    })
  }

}
