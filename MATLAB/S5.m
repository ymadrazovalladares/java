% Gráfica de S5.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=6;
s5=Amplitud* sin(2*pi*f*7*t + Fase);
plot(t,s5,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;