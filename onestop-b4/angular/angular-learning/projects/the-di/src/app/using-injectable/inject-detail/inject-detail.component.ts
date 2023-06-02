import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { InjectorService } from '../../services/using-injector.service';

@Component({
  selector: 'app-inject-detail',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './inject-detail.component.html'
})
export class InjectDetailComponent {

  targetData:any

  constructor(private route:ActivatedRoute, private service:InjectorService) {
    this.route.queryParamMap.subscribe(param => {
      const id = + (param.get('id') as string)
      this.targetData = this.service.findById(id);
    })
  }

}
