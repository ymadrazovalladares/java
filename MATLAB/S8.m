
 hold on;
 f=1E12; 
 t=0:1E-14:1E-12;
 Amplitud=288;
 fase = 0;
 for j=1:20
     s1=(288* sin(2*pi*f*t + fase))+(55* sin(2*pi*f*t + fase));
     plot(t,s1,'LineWidth',2);
     fase = fase + 5;
 end
grid on;
title ('Señal sinusoidal seno con amplitud 288 con 1t');
axis([0 1E-12 -400 400]);
xlabel ('t (segundos)');