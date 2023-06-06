import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from 'src/app/utils/widgets/page-title/page-title.component';
import { AccountOverallComponent } from 'src/app/utils/widgets/account/account-overall/account-overall.component';
import { AccountListComponent } from 'src/app/utils/widgets/account/account-list/account-list.component';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule, PageTitleComponent, AccountOverallComponent, AccountListComponent],
  templateUrl: './accounts.component.html'
})
export class AccountsComponent {

  totalAmount:any

  getTotalAmount(amount:any) {
    this.totalAmount = amount
  }

}
