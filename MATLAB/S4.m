% Gráfica de S4.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=19;
s4=Amplitud* cos(2*pi*f*5*t + Fase);
plot(t,s4,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;