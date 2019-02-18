
hold on;
f=1E12; 
t=0:1E-14:1E-12;
Amplitud=288;
fase = 0;
 for j=1:25
     s1=Amplitud* sin(2*pi*f*t + fase);
     plot(t,s1,'LineWidth',2);
     fase = fase + 15;
 end
grid on;
title ('Señal sinusoidal seno con amplitud 288 con 1t');
axis([0 1E-12 -350 350]);
xlabel ('t (segundos)');