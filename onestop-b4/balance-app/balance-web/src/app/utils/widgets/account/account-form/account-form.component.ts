import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-account-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './account-form.component.html'
})
export class AccountFormComponent {

  form:FormGroup
  icons = [
    './../../../../../assets/account/card.svg',
    './../../../../../assets/account/cash.svg',
    './../../../../../assets/account/kpay.svg',
    './../../../../../assets/account/wave.svg',
    './../../../../../assets/account/saving.svg',
    './../../../../../assets/account/visa.svg'
  ]
  srcValue:any

  @Output()
  onSave = new EventEmitter<any>

  @Input()
  set data(data:any) {
    this.initForm()

    if(data?.id > 0)
      this.form.patchValue(data)

    this.srcValue = data?.icon
  }

  constructor(private builder:FormBuilder) {
    this.form = this.builder.group({
      id: 0,
      name: ['', Validators.required],
      initialAmount: [0, Validators.required]
    })
  }

  save() {
    let value = {...this.form.value, icon: this.srcValue}

    if(this.form.valid)
      this.onSave.emit(value)

    this.initForm()

  }

  addSrcValue(value:any) {
    this.srcValue = value
  }

  initForm() {
    this.form.patchValue({
      id: 0,
      name: '',
      initialAmount: 0
    })
    this.srcValue = undefined
  }

}
