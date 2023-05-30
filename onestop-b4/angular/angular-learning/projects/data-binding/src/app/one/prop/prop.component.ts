import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-prop',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './prop.component.html',
  styleUrls: ['./prop.component.css']
})
export class PropComponent {

  minVal = 1
  valueVal = 100
  maxVal = 300

}
