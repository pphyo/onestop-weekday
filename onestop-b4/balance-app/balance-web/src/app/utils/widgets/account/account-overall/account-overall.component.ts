import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BalanceService } from 'src/app/services/balance.service';

@Component({
  selector: 'app-account-overview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-overall.component.html'
})
export class AccountOverallComponent {

  @Input()
  totalBalance:any

  expenseAmount:any

  constructor(private service:BalanceService) {
    this.service.getExpenseAmount('Expense').subscribe(result => this.expenseAmount = result)
  }

}
