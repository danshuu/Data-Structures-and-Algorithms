function VOut = seqa(b,i,T)
% Mimics seqa() from Gauss.
% Requires 3 arguments, a begining value, and incrementer, and
% the total number of elements in the output vector.
% As in Gauss, the output is a column vector.


if i == 0;  
  VOut = zeros(T,1)+b;
else;
  EndValue = ((T-1)*i)+b;
  xxx = b:i:EndValue;  % a row vector
  VOut = xxx';
end;