% Gráfica de S6.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=3;
s6=Amplitud* cos(2*pi*f*10*t + Fase);
plot(t,s6,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;