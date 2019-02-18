f=1E12; 
t=0:1E-14:1E-12;
Fase=0;
Amplitud=738;
s1aa=Amplitud* sin(2*pi*f*t + Fase);

st=s1aa+s2+s3+s4+s5+s6;
plot(t,st,'LineWidth',2); 
xlabel ('t (segundos)');
title ('Señal');
grid on;