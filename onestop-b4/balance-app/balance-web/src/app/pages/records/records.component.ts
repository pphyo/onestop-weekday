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
  list:any = []

  constructor(private service:BalanceService) {}

  ngOnInit(): void {
    this.balanceFormModal = new bootstrap.Modal('#balanceForm', {backdrop: false})
  }

  displayForm(data:any) {
    if(data)
      this.balanceFormModal.show()
  }

  save(data:any) {
    this.service.save(data).subscribe(result => this.list.push(result))
    this.balanceFormModal.hide()
  }

}
