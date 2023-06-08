import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from 'src/app/utils/widgets/page-title/page-title.component';
import { BalanceSearchComponent } from 'src/app/utils/widgets/balance/balance-search/balance-search.component';
import { BalanceListComponent } from 'src/app/utils/widgets/balance/balance-list/balance-list.component';
import { BalanceFormComponent } from 'src/app/utils/widgets/balance/balance-form/balance-form.component';
import { BalanceService } from 'src/app/services/balance.service';

declare var bootstrap:any

@Component({
  selector: 'app-records',
  standalone: true,
  imports: [CommonModule, PageTitleComponent, BalanceSearchComponent, BalanceListComponent, BalanceFormComponent],
  templateUrl: './records.component.html'
})
export class RecordsComponent implements OnInit {

  balanceFormModal:any
  balances:any
  targetDate:any
  keys:string[] = []

  constructor(private service:BalanceService) {}

  ngOnInit(): void {
    this.search(this.targetDate ? this.targetDate : new Date)
    this.balanceFormModal = new bootstrap.Modal('#balanceForm', {backdrop: false})
  }

  search(date:Date) {
    this.targetDate = date
    this.service.searchInSpecificMonth(date).subscribe(result => {
      this.keys = Object.keys(result)
      Object.keys(result).length ? this.balances = result : this.balances = undefined
    })
  }

  displayForm(data:any) {
    if(data)
      this.balanceFormModal.show()
  }

  save(data:any) {
    this.service.save(data).subscribe(result => this.balances.push(result))
    this.balanceFormModal.hide()
    this.search(this.targetDate ? this.targetDate : new Date)
  }

}
