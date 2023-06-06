import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountFormComponent } from '../account-form/account-form.component';
import { AccountsService } from 'src/app/services/accounts.service';
import { Router } from '@angular/router';
import { ConfirmComponent } from '../../confirm/confirm.component';
import { NoDataComponent } from '../../no-data/no-data.component';

declare var bootstrap:any

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule, AccountFormComponent, ConfirmComponent, NoDataComponent],
  templateUrl: './account-list.component.html'
})
export class AccountListComponent implements OnInit {

  accounts:any = []

  targetAccount:any
  accountEditModal:any

  confirmModal:any
  removeId:any

  @Output()
  amountEmitter = new EventEmitter<any>

  constructor(private service:AccountsService, private route:Router){}

  ngOnInit(): void {
    this.search()
    this.accountEditModal = new bootstrap.Modal('#accountForm', {backdrop: false})
    this.confirmModal = new bootstrap.Modal('#confirm', {backdrop: false})
    this.emitAmount()
  }

  search() {
    this.service.search().subscribe(result => this.accounts = result)
  }

  add() {
    this.targetAccount = {id: 0}
    this.accountEditModal.show()
  }

  save(form:any) {
    this.service.save(form).subscribe(result => {
      this.service.search().subscribe(res => this.accounts = res)
      this.emitAmount()
    })
    this.accountEditModal.hide()

  }

  edit(acc:any) {
    this.targetAccount = acc
    this.accountEditModal.show()
  }

  emitAmount() {
    this.service.getTotalBalance().subscribe(result => this.amountEmitter.emit(result))
  }

  remove(id:any) {
    this.confirmModal.show()
    this.removeId = id
  }

  confirm(id:any) {
    this.service.remove(id).subscribe(result => {
      this.search()
    })
    this.confirmModal.hide()
  }

}
