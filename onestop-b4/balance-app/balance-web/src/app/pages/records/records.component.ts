import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from 'src/app/utils/widgets/page-title/page-title.component';
import { BalanceSearchComponent } from 'src/app/utils/widgets/balance/balance-search/balance-search.component';
import { BalanceListComponent } from 'src/app/utils/widgets/balance/balance-list/balance-list.component';
import { BalanceFormComponent } from 'src/app/utils/widgets/balance/balance-form/balance-form.component';
import { BalanceService } from 'src/app/services/balance.service';
import { BalanceDetailComponent } from 'src/app/utils/widgets/balance/balance-detail/balance-detail.component';

declare var bootstrap:any

@Component({
  selector: 'app-records',
  standalone: true,
  imports: [CommonModule, PageTitleComponent, BalanceSearchComponent, BalanceListComponent, BalanceFormComponent, BalanceDetailComponent],
  templateUrl: './records.component.html'
})
export class RecordsComponent implements OnInit {

  balanceFormModal:any
  balanceDetailModal:any
  balances:any
  targetDate:any
  creation:any
  detailData:any
  keys:string[] = []

  constructor(private service:BalanceService) {}

  ngOnInit(): void {
    this.search(this.targetDate ? this.targetDate : new Date)
    this.balanceFormModal = new bootstrap.Modal('#balanceForm', {backdrop: false})
    this.balanceDetailModal = new bootstrap.Modal('#balanceDetail', {backdrop: false})
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
    this.creation = new Date
  }

  save(data:any) {
    this.service.save(data).subscribe(result => this.search(this.targetDate ? this.targetDate : result.creation))
    this.balanceFormModal.hide()
    this.search(this.targetDate ? this.targetDate : new Date)
  }

  showDetail(data:any) {
    this.detailData = data
    this.balanceDetailModal.show()
  }

  remove(id:any) {
    this.service.remove(id).subscribe(result => this.search(this.targetDate ? this.targetDate : new Date))
    this.balanceDetailModal.hide()
  }

  edit(data:number) {
    if(data) {
      this.balanceDetailModal.hide()
      this.balanceFormModal.show()
    }
  }

}
