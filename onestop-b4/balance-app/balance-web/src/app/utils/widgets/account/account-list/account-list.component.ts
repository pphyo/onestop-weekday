import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountFormComponent } from '../account-form/account-form.component';
import { AccountsService } from 'src/app/services/accounts.service';
import { Router } from '@angular/router';

declare var bootstrap:any

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule, AccountFormComponent],
  templateUrl: './account-list.component.html'
})
export class AccountListComponent implements OnInit {

  accounts:any = []
  targetAccount:any
  accountEditModal:any

  @Output()
  amountEmitter = new EventEmitter<any>

  constructor(private service:AccountsService, private route:Router){
    this.service.search().subscribe(result => this.accounts = result)
  }

  ngOnInit(): void {
    this.accountEditModal = new bootstrap.Modal('#accountForm', {backdrop: false})
    this.emitAmount()
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

}
