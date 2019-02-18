% Gráfica de S3.
t=0:10^-14:10^-12;
f=10^12; 
T=1/f;   
Fase=0;
Amplitud=30;
S3=Amplitud* sin(2*pi*f*3*t + Fase);
plot(t,S3,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;