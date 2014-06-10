
function p001 (multiples, limit) {

    var sum = 0;

    for (var i = 1; i < limit; i++) {

        for (var m = 0; m < multiples.length; m++) {

            if (i % multiples[m] == 0) {

                sum += i;

                break;
            }
        }
    }

    return sum;
};

var d1 = new Date();

var sum = p001([3, 5], 1000);

var d2 = new Date();

print('solution: ' + sum + ', in ' + (d2 - d1) + 'ms');