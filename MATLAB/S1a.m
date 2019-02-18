% Gráfica de S1.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=288;
s1=Amplitud* sin(2*pi*f*t + Fase);
plot(t,s1,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;