
function p003 (limit) {

    var primes = [2],
        factor;

    for (var i = primes[0] + 1, i_limit = Math.sqrt(limit), i_increment = primes[0]; i <= i_limit; i += i_increment) {

        var use = true;

        for (var p = 0, p_limit = Math.sqrt(i); p < primes.length && primes[p] <= p_limit; p++) {

            if (i % primes[p] == 0) {

                use = false;

                break;
            }
        }

        if (use) {

            if (limit % i == 0) {

                factor = i;
            }

            primes.push(i);
        }
    }

    return factor;
}

var d1 = new Date();

var sum = p003(600851475143);

var d2 = new Date();

print('solution: ' + sum + ', in ' + (d2 - d1) + 'ms');