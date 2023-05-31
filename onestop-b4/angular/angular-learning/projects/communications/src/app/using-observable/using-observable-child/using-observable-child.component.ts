import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-using-observable-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './using-observable-child.component.html'
})
export class UsingObservableChildComponent {
  @Input()
  emitter?:Subject<string>
}
