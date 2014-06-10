function p002 (limit)
{
    var sum = 0;

    var x = 0,
        y = 1,
        z;

    while (y < limit)
    {
        z = x + y;
        x = y;
        y = z;

        if (x & 1 == 1) //if (x % 2 == 0)
        {
            sum += x;
        }
    }

    return sum;
}

var d1 = new Date();

var sum = p002(4000000);

var d2 = new Date();

print('solution: ' + sum + ', in ' + (d2 - d1) + 'ms');