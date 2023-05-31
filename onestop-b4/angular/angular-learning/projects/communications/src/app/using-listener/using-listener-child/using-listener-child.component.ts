import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StringValueListener } from '../using-listener.component';

@Component({
  selector: 'app-using-listener-child',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './using-listener-child.component.html'
})
export class UsingListenerChildComponent {

  value = ''

  @Input()
  childListener?:StringValueListener

  add() {
    if(this.value && this.childListener) {
      this.childListener.take(this.value)
      this.value = ''
    }
  }

}
