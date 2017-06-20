function[c, ceq] = ConFunEx1(x)
% from pg 1-8 of Optimization Manual

% Next are nonlinear INequality constraints 
c = [1.5 + x(1)*x(2) - x(1) - x(2); 
    -x(1)*x(2) - 10];  % 2x1 vector

% Next are nonlinear equality constraints
ceq=[];  % none exist, but need to send back something, so send empty matx.

