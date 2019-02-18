% Gráfica de S2.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=55;
s2=Amplitud* cos(2*pi*f*2*t + Fase);
plot(t,s2,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;