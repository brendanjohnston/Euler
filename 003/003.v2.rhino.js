function p003 (limit) {

    var factors = [];

    if (limit % 2 == 0) {

        factors.push(2);
    }

    for (var i = 3, i_limit = Math.sqrt(limit); i <= i_limit; i += 2) {

        if (limit % i == 0) {

            factors.push(i);
        }
    }

    var factor = factors[0];

    for (var i = 0; i < factors.length; i++) {

        var use = true;

        for (var j = 0, j_limit = factors[i] / 2; j < i && factors[j] <= j_limit; j++) {

            if (factors[i] % factors[j] == 0) {

                use = false;
            }
        }

        if (use) {

            factor = factors[i];
        }
    }

    return factor;
}

var d1 = new Date();

var sum = p003(600851475143);

var d2 = new Date();

print('solution: ' + sum + ', in ' + (d2 - d1) + 'ms');