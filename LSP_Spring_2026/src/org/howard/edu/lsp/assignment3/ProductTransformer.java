package org.howard.edu.lsp.assignment3;

/**
 * Contract for transforming a validated input record into an output record.
 * Enables polymorphism: the pipeline can work with any implementation.
 */
public interface ProductTransformer {

  /**
   * Transforms a validated record into the required output record format.
   *
   * @param input Validated input record.
   * @return Transformed output record.
   */
  ProductOutputRecord transform(ProductInputRecord input);
}