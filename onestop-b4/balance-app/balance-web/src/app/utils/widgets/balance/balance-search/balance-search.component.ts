import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { balanceType, dateToString } from 'src/app/services/data';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-balance-search',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './balance-search.component.html'
})
export class BalanceSearchComponent {

  balType = balanceType
  curDate:any
  date:Date

  @Output()
  onAdd = new EventEmitter<boolean>

  constructor() {
    this.date = new Date
    this.curDate = dateToString(this.date)
  }

  add(event:boolean) {
    this.onAdd.emit(event)
  }

  plusMonth() {
    this.date.setMonth(this.date.getMonth() + 1)
    this.curDate = dateToString(this.date)
  }

  minusMonth() {
    this.date.setMonth(this.date.getMonth() - 1)
    this.curDate = dateToString(this.date)
  }

}
