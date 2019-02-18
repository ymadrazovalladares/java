% Gráfica de S3.
f=1E12; 
T=1/f;
t=0:1E-14:1E-12;
Fase=0;
Amplitud=30;
s3=Amplitud* sin(2*pi*f*3*t + Fase);
plot(t,s3,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;