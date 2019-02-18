% Gráfica de S6.
t=0:10^-15:10^-12;
f=10^12;
T=1/f;   
Fase=0;
Amplitud=3;
S6=Amplitud*cos(2*pi*f*10*t + Fase);
plot(t,S6,'LineWidth',2);
xlabel ('t (segundos)');
title ('Señal');
grid on;