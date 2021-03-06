import 'hammerjs';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {BsDropdownModule} from 'ngx-bootstrap';
import {RouterModule, Routes} from '@angular/router';
import {AlertModule} from 'ngx-bootstrap';
import {AppComponent} from './app.component';
import {CadastroUsuarioComponent} from './cadastro-usuario/cadastro-usuario.component';
import {ServicoUsuarioService} from './cadastro-usuario/servico-usuario.service';
import {BairroService} from './models/bairro.service';
import {LoginDialogComponent} from './login-dialog/login-dialog.component';
import {CadastroVagaComponent} from './cadastro-vaga/cadastro-vaga.component';
import {CdkTableModule} from '@angular/cdk/table';
import {MainScreenComponent} from './main-screen/main-screen.component';
import {ImageListComponent} from './main-screen/image-list/image-list.component';
import {ImageComponent} from './main-screen/image-list/image.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {CurrencyMaskModule} from "ng2-currency-mask";
import {InformationComponent} from './information/information.component';
import {SlideListComponent} from './information/slide-list/slide-list.component';
import {SlideComponent} from './information/slide-list/slide.component';
import {FinancialMovementComponent} from './financial-movement/financial-movement.component';
import {ScreenHomeComponent} from './screen-home/screen-home.component';
import {CarouselModule} from 'ngx-bootstrap';
import {CadastroEstacionamentoComponent} from './cadastro-estacionamento/cadastro-estacionamento.component'
import {EstacionamentoService} from './cadastro-estacionamento/estacionamento.service';
import {ServicoLoginService} from './login-dialog/servico-login.service';
import {LoginGuard} from './login-guard/login.guard';
import {CidadeService} from './models/cidade.service';
import {ImgUsuarioService} from './models/imgUsuario.service';
import {LocalidadeService} from './models/localidade.service';
import {NoLoginGuard} from './no-login/no-login.guard';
import {UploadImageComponent} from './upload-image/upload-image.component';
import {TextMaskModule} from 'angular2-text-mask';
import { AgmCoreModule } from '@agm/core';

const appRoutes: Routes = [
  {path: '', component: ScreenHomeComponent},
  {path: 'new_user', component: CadastroUsuarioComponent, canActivate: [NoLoginGuard]},
  {path: 'edit', component: CadastroUsuarioComponent, canActivate: [LoginGuard]},
  {path: 'information/:id', component: InformationComponent},
  {path: 'parking/:id', component: CadastroEstacionamentoComponent},
  {path: 'new_parking', component: CadastroEstacionamentoComponent, canActivate: [LoginGuard]},
  {path: 'my_parking', component: MyParkingComponent, canActivate: [LoginGuard]},
  {path: 'main/:nome', component: ScreenHomeComponent}
];

import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule
} from '@angular/material';
import {MyParkingComponent} from './my-parking/my-parking.component';
import {DisplayCadastreComponent} from './display-cadastre/display-cadastre.component';
import { InformationService } from './information/information.service';
import {ImgEstacionamentoService} from './models/img-estacionamento.service';

@NgModule({
  declarations: [
    AppComponent,
    CadastroUsuarioComponent,
    MainScreenComponent,
    ImageListComponent,
    ImageComponent,
    HeaderComponent,
    FooterComponent,
    LoginDialogComponent,
    CadastroVagaComponent,
    InformationComponent,
    SlideListComponent,
    SlideComponent,
    FinancialMovementComponent,
    ScreenHomeComponent,
    CadastroEstacionamentoComponent,
    UploadImageComponent,
    MyParkingComponent,
    DisplayCadastreComponent
  ],

  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}
    ),
    CarouselModule.forRoot(),
    AlertModule.forRoot(),
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCogHRSH3rJOK7nqcvRx88N2zvF0zb6GqA'
    }),
    HttpModule,
    ReactiveFormsModule,
    BrowserModule,
    TextMaskModule,
    BrowserAnimationsModule,
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    BsDropdownModule.forRoot(),
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    CurrencyMaskModule
  ],
  entryComponents: [
    LoginDialogComponent
  ],
  providers: [
    ServicoUsuarioService,
    BairroService,
    CidadeService,
    EstacionamentoService,
    LocalidadeService,
    LoginGuard,
    NoLoginGuard,
    ServicoLoginService,
    UploadImageComponent,
    ImgUsuarioService,
    ImgEstacionamentoService,
    InformationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}