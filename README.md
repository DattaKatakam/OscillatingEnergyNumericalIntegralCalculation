1. Problem
From an oscillating energy system you’ve got the equation for the power:
𝑃(𝑡) = 𝑎1 ∗ 𝑡 + sin(2 ∗ 𝜋 ∗ 𝑓1 ∗ 𝑡)
Whereat:
𝑎1 =
[𝑌𝑜𝑢𝑟 𝑟𝑒𝑔𝑖𝑠𝑡𝑟𝑎𝑡𝑖𝑜𝑛 𝑛𝑢𝑚𝑏𝑒𝑟]
40 000 𝑊
𝑓1 = 2 𝐻𝑧
For this system you want to calculate the energy consumption E(t) for t=20 seconds.
𝐸(𝑡) = ∫ 𝑃(𝑡)𝑑𝑡

2. Hand in
Hand in is only accepted via moodle with the file formats .pdf and .java. 
Hand in the following elements:
A .pdf-document with the following content:
 Exact result (not the calculation process) of the integration (see 3.2)
 Plot of the function P(t) (see 3.1)
 Nassi-Schneiderman diagrams for all three algorithms stated in 3.3
 UML-diagram(s) for the software structure
 Results of the numerical integration
 Visualization of the integral according to figure 1, 2, and 3 (blue area)
 Absolut and relative error of the numerical results
And your source code (Remember to send all files – especially if you used a class from a seminar or 
lecture):
 Java class(es) with implementation
o Calculating the numerical integral
o Plot original function
o Calculate absolut and relative error (in %) in relation to the manual calculated 
integral
 Java class(es) for testing

3. Tasks
3.1 Calculating grid points and plot
Calculate at least 10 grid points per second and plot the function P(t) in the range of 20 seconds.
3.2 Calculating the analytical integral
Calculate the analytical integral of P(t) by hand.
3.3 Calculate the numerical integral
Calculate the numerical integral with the 3 methods listed below. Use the calculated grid points only 
for the calculation:
1. Take the value, y0, of gridpoint [x0,y0] as height for the area between x0 and x1 (see figure 1)
2. Take the mean value from y0 and y1 as value for the area between x0 and x1 (see figure 2)
3. Linear interpolation between two consecutive points (see figure 3)