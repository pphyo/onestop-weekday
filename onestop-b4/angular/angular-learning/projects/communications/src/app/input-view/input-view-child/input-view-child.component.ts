import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-input-view-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './input-view-child.component.html'
})
export class InputViewChildComponent {
  list:any = []
}
