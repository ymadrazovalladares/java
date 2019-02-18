% Gráfica de S5.
t=0:10^-15:10^-12;
f=10^12; 
T=1/f;   
Fase=0;
Amplitud=6;
S5=Amplitud*sin(2*pi*f*7*t + Fase);
plot(t,S5,'LineWidth',2);
xlabel ('t (segundos)');
title ('Señal');
grid on;