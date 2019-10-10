import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TimelineComponent } from './timeline/timeline.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { FollowingComponent } from './following/following.component';
import { UserComponent } from './user/user.component';
import { ProfileComponent } from './profile/profile.component';
import { DialogpeepComponent } from './dialogpeep/dialogpeep.component';
import { ProfiledialogComponent } from './profiledialog/profiledialog.component';



const routes: Routes = [
  {path: '', redirectTo:'/auth', pathMatch:'full' },
  {path: 'auth', component: AuthenticateComponent},
  {path: 'timeline', component: TimelineComponent},
  {path: 'following/:id', component: FollowingComponent},
  {path: 'user', component: UserComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'dialogpeep', component: DialogpeepComponent},
  {path: 'dialogprofile', component: ProfiledialogComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
// tslint:disable-next-line:max-line-length
export const routingComponents = [AuthenticateComponent, TimelineComponent, FollowingComponent, UserComponent, ProfileComponent, DialogpeepComponent, ProfiledialogComponent];
