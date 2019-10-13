import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticateComponent } from './pages/authenticate/authenticate.component';
import { TimelineComponent } from './pages/timeline/timeline.component';
import { FollowingComponent } from './pages/following/following.component';
import { UserComponent } from './pages/user/user.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { DialogpeepComponent } from './pages/dialogpeep/dialogpeep.component';
import { ProfiledialogComponent } from './pages/profiledialog/profiledialog.component';



const routes: Routes = [
  {path: '', redirectTo:'pages/auth', pathMatch:'full' },
  {path: 'pages/auth', component: AuthenticateComponent},
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
