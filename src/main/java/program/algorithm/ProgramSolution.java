package program.algorithm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ProgramSolution {
    public final void test() {
        log.info("solution test begin...");

        solution();

        log.info("solution test end...");
    }

    protected abstract void solution();
}
