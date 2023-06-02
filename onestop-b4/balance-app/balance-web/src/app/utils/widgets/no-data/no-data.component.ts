import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-no-data',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './no-data.component.html'
})
export class NoDataComponent {

  @Input()
  name:any

}
