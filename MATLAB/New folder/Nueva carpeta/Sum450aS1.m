clc;
clear all;
close all;

t=0:10^-15:10^-12;
f=10^12;
Fase=0;
Amplitud1=738;
S1=Amplitud1* sin(2*pi*f*t + Fase);
Amplitud2=55;
S2=Amplitud2* cos(2*pi*f*2*t + Fase);
Amplitud3=30;
S3=Amplitud3* sin(2*pi*f*3*t + Fase);
Amplitud4=19;
S4=Amplitud4*cos(2*pi*f*5*t + Fase);
Amplitud5=6;
S5=Amplitud5*sin(2*pi*f*7*t + Fase);
Amplitud6=3;
S6=Amplitud6*cos(2*pi*f*10*t + Fase);

ST= S1+S2+S3+S4+S5+S6;
plot(t,ST,'LineWidth',2);
xlabel ('t (segundos)');
title ('Suma de Señales');
grid on;