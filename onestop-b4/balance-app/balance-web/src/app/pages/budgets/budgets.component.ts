import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageTitleComponent } from 'src/app/utils/widgets/page-title/page-title.component';

@Component({
  selector: 'app-budgets',
  standalone: true,
  imports: [CommonModule, PageTitleComponent],
  templateUrl: './budgets.component.html'
})
export class BudgetsComponent {

}
