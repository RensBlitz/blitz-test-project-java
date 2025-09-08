package org.example.dependent.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckoutServiceTest {

    @Mock
    private TaxCalculator taxCalculator;

    @Mock
    private PaymentGatewayClient paymentGatewayClient;

    @Mock
    private ReceiptGenerator receiptGenerator;

    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        checkoutService = new CheckoutService(taxCalculator, paymentGatewayClient, receiptGenerator);
    }

    @Test
    void processCheckout_WithValidInput_ShouldCallCollaboratorsAndReturnReceipt() {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void processCheckout_WhenTaxCalculatorThrows_ShouldPropagate() {
        // Arrange

        // Act & Assert
    }

    @Test
    void processCheckout_WhenPaymentGatewayThrows_ShouldPropagate() {
        // Arrange

        // Act & Assert
    }

    @Test
    void processCheckout_WithDifferentCurrency_ShouldPassCurrencyAlong() {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void processCheckout_MultipleCheckouts_ShouldInteractWithDependenciesEachTime() {
        // Arrange

        // Act

        // Assert
    }
}


