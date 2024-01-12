package com.fox.task13;

public class ClassicFormatter implements Formatter {

	private final static char MINUS = '_';
	private final static char PIPE = '|';

	public String format(DivisionResult input) {

		StringBuilder output = new StringBuilder();
		boolean firstRow = true;
		boolean isFirstStepNotFound = true;
		int offset = 0; // left offset
		for (Step step : input.getSteps()) {

			if (!(input.getSteps().get(firstMinuendIndex(input)).equals(step)) && isFirstStepNotFound) {
				continue;
			}
			if (firstRow) {
				offset = renderFirstPart(output, input, step);
				firstRow = false;
				isFirstStepNotFound = false;
			} else {
				offset = renderMidPart(output, step, offset);
			}
		}

		renderLastPart(output, input, offset); // reminder

		return output.toString();
	}

	private int renderFirstPart(StringBuilder output, DivisionResult input, Step step) {
		int offset = 0;
		int spacesAfterAmount;
		int currentSubtrahend;
		output.append(MINUS);
		output.append(input.getDividend());
		output.append(PIPE);
		output.append(input.getDivisor());
		output.append("\n");

		offset = 1 + MathUtils.length(step.getMinuend()) - MathUtils.length(step.getSubtrahend());

		output.append(StringUtils.spacer(offset));
		currentSubtrahend = step.getSubtrahend();
		output.append(currentSubtrahend);

		spacesAfterAmount = MathUtils.length(input.getDividend()) - offset - MathUtils.length(currentSubtrahend) + 1;
		output.append(StringUtils.spacer(spacesAfterAmount));
		output.append(PIPE);
		output.append(StringUtils.dashLine(MathUtils.length(input.getQuotient())));
		output.append("\n");

		output.append(StringUtils.spacer(offset));
		output.append(StringUtils.dashLine(MathUtils.length(currentSubtrahend)));
		output.append(StringUtils.spacer(spacesAfterAmount));
		output.append(PIPE);
		output.append(input.getQuotient());
		output.append("\n");

		if (step.getDifference() == 0) {
			offset += MathUtils.length(step.getSubtrahend()) - 1;
		}

		return offset;
	}

	private int renderMidPart(StringBuilder output, Step step, int offset) {
		if (step.getSubtrahend() != 0) {

			output.append(StringUtils.spacer(offset));
			output.append(MINUS);
			output.append(step.getMinuend());
			output.append("\n");

			offset += MathUtils.length(step.getMinuend()) - MathUtils.length(step.getSubtrahend()) + 1;

			output.append(StringUtils.spacer(offset));
			output.append(step.getSubtrahend());
			output.append("\n");

			output.append(StringUtils.spacer(offset));
			output.append(StringUtils.dashLine(MathUtils.length(step.getSubtrahend())));
			output.append("\n");

			offset += MathUtils.length(step.getSubtrahend()) - MathUtils.length(step.getDifference()) - 1;
			if (step.getDifference() == 0) {
				offset++;
			}

		}
		return offset;
	}

	private void renderLastPart(StringBuilder output, DivisionResult input, int offset) {

		int lastStepIndex = MathUtils.length(input.getDividend()) - 1;
		int reminder = input.getReminder();
		offset += MathUtils.length(input.getSteps().get(lastStepIndex).getSubtrahend()) - MathUtils.length(reminder);
		output.append(StringUtils.spacer(offset));
		output.append(reminder);

	}

	private int firstMinuendIndex(DivisionResult input) {
		int i = 0;
		for (int j = 0; j < input.getSteps().size(); j++) {
			if (input.getSteps().get(j).getQuotient() > 0) {
				break;
			}
			i++;
		}
		return i;
	}

}
