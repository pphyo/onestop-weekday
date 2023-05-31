import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-local-child',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './local-child.component.html',
  styleUrls: ['./local-child.component.css']
})
export class LocalChildComponent {

}
