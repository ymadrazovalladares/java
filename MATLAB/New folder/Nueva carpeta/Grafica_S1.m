% Gráfica de S1.
t=0:10^-14:10^-12;
f=10^12; 
T=1/f;   
Fase=0;
Amplitud=288;
S1=Amplitud* sin(2*pi*f*t + Fase);
plot(t,S1,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;