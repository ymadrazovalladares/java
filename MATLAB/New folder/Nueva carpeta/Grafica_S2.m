% Gráfica de S2.
t=0:10^-14:10^-12;
f=10^12; 
T=1/f;   
Fase=0;
Amplitud=55;
S2=Amplitud* cos(2*pi*f*2*t + Fase);
plot(t,S2,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;