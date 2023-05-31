import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LocalChildComponent } from './local-child/local-child.component';

@Component({
  selector: 'app-local',
  standalone: true,
  imports: [CommonModule, LocalChildComponent],
  templateUrl: './local.component.html',
})
export class LocalComponent {

}
