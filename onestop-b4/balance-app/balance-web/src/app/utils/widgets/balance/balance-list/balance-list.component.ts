import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NoDataComponent } from '../../no-data/no-data.component';

@Component({
  selector: 'app-balance-list',
  standalone: true,
  imports: [CommonModule, NoDataComponent],
  templateUrl: './balance-list.component.html'
})
export class BalanceListComponent {

  @Input()
  balances:any

  @Input()
  keys:any = []

  @Output()
  onShow = new EventEmitter<any>

  checkType(checked:boolean, result:string, def:string) {
    return checked ? result : def;
  }

  showDetail(data:any) {
    this.onShow.emit(data)
  }

}
