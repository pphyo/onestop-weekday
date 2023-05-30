import { Routes } from '@angular/router';
import { InterpoComponent } from './interpo/interpo.component';
import { PropComponent } from './one/prop/prop.component';
import { AttrComponent } from './one/attr/attr.component';
import { EventComponent } from './event/event.component';
import { TwoComponent } from './two/two.component';

export const routes: Routes = [
  {path: 'interpo', component: InterpoComponent},
  {path: 'one', children: [
    {path: 'prop', component: PropComponent},
    {path: 'attr', component: AttrComponent},
    {path: '', pathMatch: 'full', redirectTo: '/one/prop'}
  ]},
  {path: 'event', component: EventComponent},
  {path: 'two', component: TwoComponent},
  {path: '**', pathMatch: 'full', redirectTo: '/interpo'}
];
