% Gráfica de S4.
t=0:10^-15:10^-12;
f=10^12;
T=1/f;   
Fase=0;
Amplitud=19;
S4=Amplitud*cos(2*pi*f*5*t + Fase);
plot(t,S4,'LineWidth',2);
xlabel ('t (segundos)');
title ('Señal');
grid on;