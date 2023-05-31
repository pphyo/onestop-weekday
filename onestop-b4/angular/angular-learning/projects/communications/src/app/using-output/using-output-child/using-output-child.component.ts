import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-using-output-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './using-output-child.component.html'
})
export class UsingOutputChildComponent {

  @Output()
  emitter = new EventEmitter<string>

}
