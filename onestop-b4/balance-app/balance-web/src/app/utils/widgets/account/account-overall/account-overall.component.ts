import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-overview',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-overall.component.html'
})
export class AccountOverallComponent {

  @Input()
  totalBalance:any

}
