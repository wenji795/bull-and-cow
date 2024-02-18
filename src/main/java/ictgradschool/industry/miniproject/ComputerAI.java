public class ComputerAI extends Player {

    public ComputerAI() {
        this.secretCode = generateComputerCode();
    }

    private String generateComputerCode() {
        // 实现生成计算机秘密代码的逻辑
        return "1234";  // 示例代码
    }

    @Override
    public String makeGuess() {
        // 如果未来需要实现电脑猜测逻辑
        return null;
    }
}
